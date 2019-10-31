package com.frozy.aboutking;

import java.util.ArrayList;
import java.util.List;

public class Kings {
    private static final String[][] data =
            {
                    {"Henry VIII", "1509", "1547", "When Richard III fell at the Battle of Bosworth, his crown was picked up and placed on the head of Henry Tudor. He married Elizabeth of York and so united the two warring houses, York and Lancaster. He was a skillful politician but avaricious. The material wealth of the country increased greatly. During Henry’s reign playing cards were invented and the portrait of his wife Elizabeth has appeared eight times on every pack of cards for nearly 500 years."},
                    {"Edward VI", "1547", "1553", "The son of Henry VIII and Jane Seymour, Edward was a sickly boy; it is thought he suffered from tuberculosis. Edward succeeded his father at the age of 9, the government being carried on by a Council of Regency with his uncle, Duke of Somerset, styled Protector. Even though his reign was short, many men made their mark. Cranmer wrote the Book of Common Prayer and the uniformity of worship helped turn England into a Protestant State. After Edward’s death there was a dispute over the succession. As Mary was Catholic, Lady Jane Grey was named as the next in line to the throne. She was proclaimed Queen but Mary entered London with her supporters and Jane was taken to the Tower. She reigned for only 9 days. She was executed in 1554, aged 17."},
                    {"Mary I", "1553", "1558", "Daughter of Henry VIII and Catherine of Aragon. A devout Catholic, she married Philip of Spain. Mary attempted to enforce the wholesale conversion of England to Catholicism. She carried this out with the utmost severity. The Protestant bishops, Latimer, Ridley and Archbishop Cranmer were among those burnt at the stake. The place, in Broad Street Oxford, is marked by a bronze cross. The country was plunged into a bitter blood bath, which is why she is remembered as Bloody Mary. She died in 1558 at Lambeth Palace in London."},
                    {"Elizabeth I", "1558", "1603", "The daughter of Henry VIII and Anne Boleyn, Elizabeth was a remarkable woman, noted for her learning and wisdom. From first to last she was popular with the people and had a genius for the selection of capable advisors. Drake, Raleigh, Hawkins, the Cecils, Essex and many many more made England respected and feared. The Spanish Armada was decisively defeated in 1588 and Raleigh’s first Virginian colony was founded. The execution of Mary Queen of Scots marred what was a glorious time in English history. Shakespeare was also at the height of his popularity. Elizabeth never married."},
                    {"James I", "1603", "1625", "James was the son of Mary Queen of Scots and Lord Darnley. He was the first king to rule over Scotland and England. James was more of a scholar than a man of action. In 1605 the Gunpowder Plot was hatched: Guy Fawkes and his Catholic friends tried to blow up the Houses of Parliament, but were captured before they could do so. James’s reign saw the publication of the Authorised Version of the Bible, though this caused problems with the Puritans and their attitude towards the established church. In 1620 the Pilgrim Fathers sailed for America in their ship The Mayflower."},
                    {"Charles I", "1625", "1649", "The son of James I and Anne of Denmark, Charles believed that he ruled by Divine Right. He encountered difficulties with Parliament from the beginning, and this led to the outbreak of the English Civil War in 1642. The war lasted four years and following the defeat of Charles’s Royalist forces by the New Model Army, led by Oliver Cromwell, Charles was captured and imprisoned. The House of Commons tried Charles for treason against England and when found guilty he was condemned to death. His death warrant states that he was beheaded on Tuesday 30 January 1649. Following this the British monarchy was abolished and a republic called the Commonwealth of England was declared."},
                    {"Charles II", "1660", "1685", "Son of Charles I, also known as the Merry Monarch. After the collapse of the Protectorate following the death of Oliver Cromwell and the flight of Richard Cromwell to France, the Army and Parliament asked Charles to take the throne. Although very popular he was a weak king and his foreign policy was inept. He had 13 known mistresses, one of whom was Nell Gwyn. He fathered numerous illegitimate children but no heir to the throne. The Great Plague in 1665 and the Great Fire of London in 1666 took place during his reign. Many new buildings were built at this time. St. Paul’s Cathedral was built by Sir Christopher Wren and also many churches still to be seen today."},
                    {"James II", "1685", "1688", "The second surviving son of Charles I and younger brother of Charles II. James had been exiled following the Civil War and served in both the French and Spanish Army. Although James converted to Catholicism in 1670, his two daughters were raised as Protestants. James became very unpopular because of his persecution of the Protestant clergy and was generally hated by the people. Following the Monmouth uprising (Monmouth was an illegitimate son of Charles II and a Protestant) and the Bloody Assizes of Judge Jeffries, Parliament asked the Dutch prince, William of Orange to take the throne.\n" +
                            "\n" +
                            "William was married to Mary, James II’s Protestant daughter. William landed in England and James fled to France where he died in exile in 1701."},
            };

    private List<King> list = new ArrayList<>();

    public Kings() {
        for (String[] array : data)
            list.add(new King(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]), array[3]));
        }

        public List<King> getKings() {return list;}

}
