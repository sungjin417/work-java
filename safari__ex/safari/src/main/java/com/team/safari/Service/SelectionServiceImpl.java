package com.team.safari.Service;

import com.team.safari.Dao.SelectionDAO;
import com.team.safari.Vo.InformationVO;
import com.team.safari.Vo.UserSelectionVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectionServiceImpl implements SelectionService {

    private final SelectionDAO selectionDAO;

    public SelectionServiceImpl(SelectionDAO selectionDAO) {
        this.selectionDAO = selectionDAO;
    }

    @Override
    public void saveSelection(UserSelectionVO selection) {
        selectionDAO.save(selection);
    }

    @Override
    public List<InformationVO> getInformationByUser(String userId) {
        return selectionDAO.findInformationByUserId(userId);
    }
}