package id;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreatorId {

    final private static String pattern = "ddMMyyyyHHmmss";

    public Long getObjectId() {
        String tableNo = "1";
        StringBuilder sb = new StringBuilder();
        sb.append(tableNo);
        sb.append(new SimpleDateFormat(pattern).format(new Date()));
        String randoms = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(10);
            randoms = randoms + num;
        }
        sb.append(randoms);
        Long id = new Long(sb.toString());
        return id;
    }

    public Long getParamsId() {
        String tableNo = "2";
        StringBuilder sb = new StringBuilder();
        sb.append(tableNo);
        sb.append(new SimpleDateFormat(pattern).format(new Date()));
        String randoms = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(10);
            randoms = randoms + num;
        }
        sb.append(randoms);
        Long id = new Long(sb.toString());
        return id;
    }

    public Long getTypeId() {
        String tableNo = "3";
        StringBuilder sb = new StringBuilder();
        sb.append(tableNo);
        sb.append(new SimpleDateFormat(pattern).format(new Date()));
        String randoms = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(10);
            randoms = randoms + num;
        }
        sb.append(randoms);
        Long id = new Long(sb.toString());
        return id;
    }

    public Long getAttribId() {
        String tableNo = "4";
        StringBuilder sb = new StringBuilder();
        sb.append(tableNo);
        sb.append(new SimpleDateFormat(pattern).format(new Date()));
        String randoms = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(10);
            randoms = randoms + num;
        }
        sb.append(randoms);
        Long id = new Long(sb.toString());
        return id;
    }
}
