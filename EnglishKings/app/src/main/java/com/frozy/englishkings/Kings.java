package com.frozy.englishkings;

import java.util.ArrayList;
import java.util.List;

public class Kings {
    private static final String[][] data =
            {
                    {"Offa", "757", "796"},
                    {"Egbert", "802", "839"},
                    {"Aethelwulf", "839", "856"},
                    {"Aethelbald", "856", "860"},
                    {"Aethelbert", "860", "866"},
                    {"Aethelred I", "866", "871"},
                    {"Alfred the Great", "871", "899"},
                    {"Edward the Elder", "899", "925"},
                    {"Athelstan", "925", "940"},
                    {"Edmund", "940", "946"},
                    {"Edred", "946", "955"},
                    {"Edwy", "955", "959"},
                    {"Edgar", "959", "975"},
                    {"Edward the Martyr", "975", "978"},
                    {"Ethelred II the Unready", "978", "1016"},
                    {"Edmund lronside", "1016", "1016"},
                    {"Cnut (Canute)", "1016", "1035"},
                    {"Harold I Harefoot", "1035", "1040"},
                    {"Harthacanut}", "1040", "1042"},
                    {"Edward the Confessor", "1042", "1066"},
                    {"Harold II", "1066", "1066"},
                    {"William I", "1066", "1087"},
                    {"William II", "1087", "1100"},
                    {"Henry I", "1100", "1135"},
                    {"Stephen", "1135", "1154"},
                    {"Henry II", "1154", "1189"},
                    {"Richard I", "1189", "1199"},
                    {"John", "1199", "1216"},
                    {"Henry III", "1216", "1272"},
                    {"Edward I", "1272", "1307"},
                    {"Edward II", "1307", "1327"},
                    {"Edward III", "13327", "1377"},
                    {"Richard II", "1377", "1399"},
                    {"Henry IV", "1399", "1413"},
                    {"Henry V", "1413", "1422"},
                    {"Henry VI ", "1422", "1461"},
                    {"Edward IV", "1461", "1483"},
                    {"Edward V", "1483", "1483"},
                    {"Richard III", "1483", "1485"},
                    {"Henry VII", "1485", "1509"},
                    {"Henry VIII", "1509", "1547"},
                    {"Edward VI", "1547", "1553"},
                    {"Mary I", "1553", "1558"},
                    {"Elizabeth I", "1558", "1603"},
                    {"James I", "1603", "1625"},
                    {"Charles I", "1625", "1649"},
                    {"Commonwealth", "1649", "1653"},
                    {"Oliver Cromwell", "1653", "1658"},
                    {"Richard Cromwell", "1658", "1659"},
                    {"Charles II", "1660", "1685"},
                    {"James II", "1685", "1688"},
                    {"William III of Orange and Mary II (jointly)", "1689", "1694"},
                    {"William III (alone)", "1694", "1702"},
                    {"Anne", "1705","1714"},
                    {"George I", "1714", "1727"},
                    {"George II", "1727", "1760"},
                    {"George III", "1760", "1820"},
                    {"George IV", "1820", "1830"},
                    {"William IV", "1830", "1837"},
                    {"Victoria", "1837", "1901"},
                    {"Edward VII", "1901", "1910"},
                    {"George V", "1910", "1936"},
                    {"Edward VIII", "1936", "1936"},
                    {"George VI", "1936", "1952"},
                    {"Elizabeth II", "1952", "2019"}
            };

    private List<King> list = new ArrayList<>();

    public Kings() {
        for (String[] array : data) {
            list.add(new King(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        }
    }
        public List<King> getKings() {return list;}

}
