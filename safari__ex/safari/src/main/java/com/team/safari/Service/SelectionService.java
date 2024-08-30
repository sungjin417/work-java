package com.team.safari.Service;

import com.team.safari.Vo.InformationVO;
import com.team.safari.Vo.UserSelectionVO;

import java.util.List;

public interface SelectionService {
    void saveSelection(UserSelectionVO selection);
    List<InformationVO> getInformationByUser(String userId);
}
