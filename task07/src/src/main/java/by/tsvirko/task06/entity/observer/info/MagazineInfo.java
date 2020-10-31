package by.tsvirko.task06.entity.observer.info;

import by.tsvirko.task06.entity.observer.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MagazineInfo {
    private static final Logger logger = LogManager.getLogger(MagazineInfo.class);

    private static MagazineInfo instance;

    //stores year as key and number of magazines as a value
    private Map<Integer, Integer> yearCountMapMagazine = new HashMap<>();

    public void update(int year, Action action) {
        Optional<Integer> count = Optional.ofNullable(yearCountMapMagazine.get(year));
        switch (action) {
            case ADD:
                if (count.isPresent()) {
                    yearCountMapMagazine.replace(year, count.get().intValue(), count.get().intValue() + 1);
                } else {
                    yearCountMapMagazine.put(year, 1);
                }
                break;
            case REMOVE:
                yearCountMapMagazine.replace(year, count.get().intValue(), count.get().intValue() - 1);
                break;
        }
        for (Map.Entry<Integer, Integer> entry : yearCountMapMagazine.entrySet()) {
            logger.info("Magazine info: " + " year=" + entry.getKey() + " count=" + entry.getValue());
        }
    }

    public static MagazineInfo getInstance() {
        return (instance == null) ? instance = new MagazineInfo() : instance;
    }
}
