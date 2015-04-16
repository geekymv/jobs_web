package com.heike.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.DictDao;
import com.heike.dao.RecruitDao;
import com.heike.dao.RecruitStuDao;
import com.heike.dao.StudentDao;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.RecruitQueryDto;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.pojo.RecruitStu;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.RecruitService;
import com.heike.domain.vo.ApplyRecordVO;
import com.heike.domain.vo.RecruitStuVO;
import com.heike.domain.vo.RecruitVO;
import com.heike.util.DateUtils;

@Service
public class RecruitServiceImpl implements RecruitService {
	@Autowired
	private RecruitDao recruitDao;
	@Autowired
	private RecruitStuDao recruitStuDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private DictDao dictDao;
	
	public void findPage(Pager<RecruitVO> pager){
		recruitDao.queryByPage(pager);
	}

	public RecruitVO getById(Long id) {
		return recruitDao.queryById(id);
	}

	public List<RecruitStuVO> getApplyStudents(Long id) {
		List<RecruitStuVO> vos = new ArrayList<RecruitStuVO>();
		List<RecruitStu> rss = recruitStuDao.queryById(id);
		if(rss != null && rss.size() > 0) {
			for (RecruitStu rs : rss) {
				String applyDate = rs.getApplyDate();
				Integer status = rs.getStatus();
				Long stuId = rs.getStuId();
				Student student = studentDao.queryById(stuId);
				String num = student.getNum();
				String name = student.getName();
				Long proId = student.getProfessionId();
				String profession = dictDao.queryById(proId).getName();
				
				RecruitStuVO vo = new RecruitStuVO(num, name, profession, applyDate, status);
				vos.add(vo);
			}
		}
		return vos;
	}

	@Override
	public String isApply(Long stuId, Long recId) {
		RecruitStu rs = recruitStuDao.queryByStuIdAndRecId(stuId, recId);
		return rs == null ? "isApplyed" : "notApply";
	}

	@Override
	public List<ApplyRecordVO> getApplyRecords(Long stuId) {
		return recruitStuDao.queryApplyRecords(stuId);
	}

	@Override
	public Pager<RecruitVO> findPage(Pager<RecruitVO> pager, RecruitQueryDto dto) {
		return recruitDao.queryByPage(pager, dto);
	}

	@Override
	public void add(Recruit recruit, Long empId) {
		recruit.setEmpId(empId);
		recruit.setReleaseDate(DateUtils.getCurrentGaDate());
		recruit.setStatus(SysCode.RecruitCode.RECRUIT_PUBLISHED);
	
		recruitDao.save(recruit);
	}

	@Override
	public int edit(Recruit recruit) {
		// 判断这条招聘信息是有学生报名
		int num = recruitDao.findApplyNum(recruit.getId());
		if(num > 0) { // 有学生报名
			return 2;
		}
		int res = recruitDao.update(recruit);
		return res;
	}

	@Override
	public boolean delete(Long id) {
		int res = recruitDao.updateStatus(id, SysCode.RecruitCode.RECRUIT_DELETED);
		return res == 1 ? true : false;
	}

	@Override
	public boolean isApplyed(Long recId) {
		int applyNum = recruitDao.findApplyNum(recId);
		return applyNum > 0 ? true : false;
	}

}
