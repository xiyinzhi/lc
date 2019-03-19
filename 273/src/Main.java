public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numberToWords(1000));
    }

    public String numberToWords(int num) {
        int len = 0;
        if (num == 0) {
            return "Zero";
        } else {
            // ****
            len = (int) (Math.log10(num) + 1);
        }
        StringBuilder sb = new StringBuilder();

        int blockNum = (len + 2) / 3;
        boolean flag = true;
        for (int i = 0; i < blockNum; i++) {
            int r = num - 1000 * (num / 1000);
            if (r == 0) {
                flag = true;
                num = num / 1000;
                continue;
            } else {
                StringBuilder piece = new StringBuilder();
                int l = (int) (Math.log10(r) + 1);
                for (int j = l; j >= 1; j--) {
                    if (j == 3) {
                        piece.append(singleNumberToWord(r / 100)).append("Hundred ");
                    } else if (j == 2) {
                        int tempr = (r - (r / 100) * 100) / 10;
                        switch (tempr) {
                            case 0:
                                break;
                            case 1:
                                flag = false;
                                break;
                            case 2:
                                piece.append("Twenty ");
                                break;
                            case 3:
                                piece.append("Thirty ");
                                break;
                            case 4:
                                piece.append("Forty ");
                                break;
                            case 5:
                                piece.append("Fifty ");
                                break;
                            case 6:
                                piece.append("Sixty ");
                                break;
                            case 7:
                                piece.append("Seventy ");
                                break;
                            case 8:
                                piece.append("Eighty ");
                                break;
                            case 9:
                                piece.append("Ninety ");
                                break;
                        }
                    } else {
                        int tempr = j - (j / 10) * 10;
                        if (!flag) {
                            switch (tempr) {
                                case 0:
                                    piece.append("Ten ");
                                    break;
                                case 1:
                                    piece.append("Eleven ");
                                    break;
                                case 2:
                                    piece.append("Twelve ");
                                    break;
                                case 3:
                                    piece.append("Thirteen ");
                                    break;
                                case 4:
                                    piece.append("Fourteen ");
                                    break;
                                case 5:
                                    piece.append("Fifteen ");
                                    break;
                                case 6:
                                    piece.append("Sixteen ");
                                    break;
                                case 7:
                                    piece.append("Seventeen ");
                                    break;
                                case 8:
                                    piece.append("Eighteen ");
                                    break;
                                case 9:
                                    piece.append("Nineteen ");
                                    break;
                            }
                        } else {
                            piece.append(singleNumberToWord(tempr));
                        }
                    }
                }

                if (i == 1) {
                    piece.append("Thousand ");
                } else if (i == 2) {
                    piece.append("Million ");
                } else if (i == 3) {
                    piece.append("Billion ");
                }

                sb.insert(0, piece);
            }

            flag = true;
            num = num / 1000;

        }
        return sb.toString().trim();
    }

    public String singleNumberToWord(int num) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return "One ";
            case 2:
                return "Two ";
            case 3:
                return "Three ";
            case 4:
                return "Four ";
            case 5:
                return "Five ";
            case 6:
                return "Six ";
            case 7:
                return "Seven ";
            case 8:
                return "Eight ";
            case 9:
                return "Nine ";
        }
        return "";
    }
}
