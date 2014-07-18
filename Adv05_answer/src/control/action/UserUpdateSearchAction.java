package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.EmployeeDTO;

public class UserUpdateSearchAction implements Action {
    private int empId;            // ���[�U�R�[�h

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
     * �߂�l�F�@���[�U�����擾�ł���΁A�X�V�����͉�ʂ̃p�X��Ԃ��B
     *          ���[�U�����擾�ł��Ȃ���΁A�G���[��ʂ̃p�X��Ԃ��B
     * ���@���F�@���͂��ꂽ���[�U�R�[�h���g�p����DBMS���烆�[�U�����擾����B
     *          ���[�U���͎���ʂ̕\���Ŏg�p���邽�߃Z�b�V�����ɕۑ�����B
     */
    public String execute(HttpServletRequest req) throws DAOException {
        NewEmployeeDAO dao = new NewEmployeeDAO();
        EmployeeDTO dto = dao.getUser(empId);
        if (dto != null) {
            HttpSession session = req.getSession(false);
            session.setAttribute("emp_dto", dto);
            return "/page/userUpdateSearchResult.jsp";
        } else {
            return "/html/checkerror.html";
        }
    }
}