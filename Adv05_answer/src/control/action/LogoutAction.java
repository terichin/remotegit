package control.action;
import javax.servlet.http.*;
import control.dao.*;

public class LogoutAction implements Action {
    /*
     * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
     *
     * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
     * �߂�l�F�@���true��Ԃ��B
     * ���@���F�@�`�F�b�N����p�����[�^�͖����̂ŁA���true��Ԃ��B
     */
    public boolean check(HttpServletRequest req) {
        // �`�F�b�N������̂������̂ŏ��true��Ԃ�
        return true;
    }

    /*
     * �@�@�\�F�@���O�A�E�g���������s���郁�\�b�h�B
     *
     * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
     * �߂�l�F�@���O�C����ʂ̃p�X��Ԃ��B
     * ���@���F�@�Z�b�V������j�����ă��O�C����ʂɑJ�ڂ���B
     */
    public String execute(HttpServletRequest req) throws DAOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            // �Z�b�V�������̂�j������
            session.invalidate();
        }
        return "/html/login.html";
    }
}