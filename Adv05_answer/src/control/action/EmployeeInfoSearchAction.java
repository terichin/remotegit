package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class EmployeeInfoSearchAction implements Action {
	private int empId;			// ���[�U�R�[�h

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂���郆�[�U�R�[�h�ɑ΂���null�`�F�b�N�Ɛ��l�`�F�b�N���s���B
	 */
	public boolean check(HttpServletRequest req) {
		// ���[�U�R�[�h�̃`�F�b�N
		String paramId = req.getParameter("EMPID");
		if ((paramId == null) || ("".equals(paramId))) {
			return false;
		}
		try {
			empId = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/*
	 * �@�@�\�F�@�w�肳�ꂽ���[�U�R�[�h�̃��[�U�����擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���[�U�����擾�ł���΁A�������ʉ�ʂ̃p�X��Ԃ��B
	 *           ���[�U�����擾�ł��Ȃ���΁A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�ԍ����g�p����DBMS���畡���̏����擾����B
	 *           ���[�U�e�[�u���A�d�b�ԍ��e�[�u���A�����e�[�u������w��̃��[�U�R�[�h��
	 *           �Ή���������擾����B�X�Ƀ��[�U���̒��̏�iID�̃��[�U����
	 *           �擾����B�����͂��ꂼ��Ή�����DTO�I�u�W�F�N�g�Ɋi�[���A�X��
	 *           ������1��ArrayList�Ɋi�[����B�����ō쐬����ArrayList�͎���ʂ�
	 *           �\���Ŏg�p���邽�߃Z�b�V�����ɕۑ�����B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		NewEmployeeDAO empDAO = new NewEmployeeDAO();
		EmployeeDTO empDTO = empDAO.getUser(empId);
		NewContactDAO contactDAO = new NewContactDAO();
		ContactDTO contactDTO = contactDAO.getContact(empId);
		NewPostDAO postDAO = new NewPostDAO();
		PostDTO postDTO = postDAO.getPost(empId);
		// ��i�̏��̎擾�B
		EmployeeDTO bossDTO = empDAO.getUser(postDTO.getBossid());
		ArrayList list = new ArrayList();
		list.add(empDTO);
		list.add(contactDTO);
		list.add(postDTO);
		list.add(bossDTO);
		HttpSession session = req.getSession(false);
		session.setAttribute("emp_list", list);
		return "/page/employeeSearch.jsp";
	}
}