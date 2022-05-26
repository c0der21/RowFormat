public class massive
{
    String t;
    int r;
    massive(String t,int r){this.t=t;this.r=r;}
    public String format(massive m) {
        String[] array = t.split(" ");
        String result = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(array[0]);
        for (int i = 0; i < array.length; i++)
            if (sb.length() + array[i].length() + 1 <= r) {
                sb.append(" ");
                sb.append(array[i]);
                if (i == array.length - 1) {
                    break;
                }
                if (sb.length() + array[i + 1].length() + 1 > r) {

                    sb1.append(sb);
                    sb1.append("\n");
                    sb.setLength(0);
                    sb.append(array[i + 1]);
                    i++;
                }
            } else {
                sb1.append(sb);
                sb1.append("\n");
                sb.setLength(0);
                sb.append(array[i]);
            }

        if (sb.length() != 0) {
    sb1.append(sb); }
    String g = sb1.toString();
        return g;
    }
}
            /*{
            String row = "";
            int k=0;
            if (array[i].length() > r)
            {
                row += RowFormat.cut(array[i], r);
                k+= r-array[i].length()-1;
            } else
            {
                row += array[i];
                for (int j = 0; j < r - array[i].length(); j++)
                {
                    row += " ";
                }
                row += "\n\r";
            }
            result += row;
        }
        return result;
    }

}

   /* String getStringsN() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(Words[0]);
        for (int i = 1; i < Words.length; i++) {
            if (sb.length() + Words[i].length() + 1 <= N) {
                sb.append(" ");
                sb.append(Words[i]);
                if (i == Words.length - 1) {
                    break;
                }
                if (sb.length() + Words[i + 1].length() + 1 > N) {

                    sb1.append(sb);
                    sb1.append("\n");
                    sb.setLength(0);
                    sb.append(Words[i + 1]);
                    i++;
                }
            } else {
                sb1.append(sb);
                sb1.append("\n");
                sb.setLength(0);
                sb.append(Words[i]);
            }
        }
        if (sb.length() != 0) {
            sb1.append(sb);
        }
        String g = sb1.toString();
        return g;
    } */