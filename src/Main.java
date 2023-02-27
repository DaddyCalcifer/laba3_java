import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);

        GUI ui = new GUI(5,5,600,230,"Введите значения последовательности...");
        ui.InputIntArrayWindow();
        int chose = -1;
        while(true) {
            System.out.println("Введите индекс задания:");
            System.out.println("1 - Задание варианта 10");
            System.out.println("2 - Задание варианта 24 (Ручной ввод)");
            System.out.println("3 - Задание варианта 24 (10 шаблонов)");
            try {
                chose = reader.nextInt();
            } catch (Exception ex) {
                System.out.println("Неверно введён индекс!");
                return;
            }
            switch (chose) {
                case 1:
                    //Solution10();
                    break;
                case 2:
                    int[] arr_ = ReadIntArray();
                    CountIdPair a = Solution24(arr_);
                    System.out.print("Самая длинная последовательность, размером " + a.array.length + ": ");

                    for (int j = 0; j < a.array.length; j++) {
                        System.out.print(a.array[j] + "  ");
                    }
                    System.out.print('\n');
                    break;
                case 3:
                    int[][] arrays = new int[][]
                            {
                                    {1, 2, -2, 1, 10, 3, 105, 4, -5, 4, 10, 1, 1, 3, 4, 7, 12, 10},
                                    {23, 71, 90, 42, 80, 24, 80, 55, 95, 28, 5, 14, 65, 98, 86, 72, 44, 16},
                                    {75, 94, 81, 78, 41, 10, 41, 1, 16, 99, 21, 69, 76, 37, 58, 77, 70, 27},
                                    {96, 63, 77, 84, 78, 89, 22, 23, 39, 77, 50, 10, 12, 29, 77, 27, 15, 72},
                                    {47, 63, 84, 23, 9, 77, 23, 78, 95, 22, 44, 83, 99, 90, 58, 64, 3, 36},
                                    {56, 90, 17, 14, 77, 98, 20, 10, 3, 89, 39, 5, 28, 70, 66, 10, 14, 11},
                                    {32, 61, 64, 30, 77, 81, 33, 34, 10, 69, 71, 66, 91, 40, 31, 55, 37, 81},
                                    {20, 83, 90, 9, 84, 33, 99, 76, 34, 42, 57, 37, 49, 19, 15, 46, 99, 57},
                                    {51, 16, 36, 45, 6, 16, 47, 23, 98, 42, 77, 77, 64, 7, 73, 60, 86, 77},
                                    {68, 60, 52, 47, 10, 4, 51, 53, 45, 35, 94, 15, 78, 45, 69, 96, 78, 59}
                            };

                    for (int i = 0; i < arrays.length; i++) {
                        CountIdPair a1 = Solution24(arrays[i]);
                        System.out.print("Самая длинная последовательность, размером " + a1.array.length + ": ");

                        for (int j = 0; j < a1.array.length; j++) {
                            System.out.print(a1.array[j] + "  ");
                        }
                        System.out.print('\n');
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверно введён индекс!");
                    break;

            }
        }
    }
    static int[] Add(int[] arr, int element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }
    static int[] ReadIntArray() {
        Scanner reader = new Scanner(System.in);
        int[] nums = new int[0];
        System.out.println("Введите значения последовательности для поиска максимума, для завершения введите любой не цифровой символ.");
        while (true)
        {
            int r;
            try
            {
                r = reader.nextInt();
            }
            catch (Exception ex) { System.out.println("Ввод значений завершён."); break;}
            nums = Add(nums,r);
        }
        return nums;
    }
    //Вариант 10
    static int[] Solution10max(int[] arr){
        int[] res = new int[0];

        res = Add(res,(arr[0] > arr[1]) ? arr[0] : arr[1]);
        for (int i=1;i < arr.length-1;i++)
        {
            int t_1 = (arr[i-1] > arr[i]) ? arr[i-1] : arr[i];
            int t_2 = (arr[i+1] > arr[i]) ? arr[i+1] : arr[i];
            res = Add(res,(t_1 > t_2) ? t_1 : t_2);
        }
        res = Add(res,(arr[arr.length-1] > arr[arr.length-2]) ? arr[arr.length-1] : arr[arr.length-2]);

        return res;
    }
    static int[] Solution10min(int[] arr){
        int[] res = new int[0];

        res = Add(res,(arr[0] < arr[1]) ? arr[0] : arr[1]);
        for (int i=1;i < arr.length-1;i++)
        {
            int t_1 = (arr[i-1] < arr[i]) ? arr[i-1] : arr[i];
            int t_2 = (arr[i+1] < arr[i]) ? arr[i+1] : arr[i];
            res = Add(res,(t_1 < t_2) ? t_1 : t_2);
        }
        res = Add(res,(arr[arr.length-1] < arr[arr.length-2]) ? arr[arr.length-1] : arr[arr.length-2]);

        return res;
    }
    static String Solution10(int[] nums) {
        //int[] nums = ReadIntArray();
        if(nums.length == 0)
        {
            System.out.print("Не введены значения последовательности!");
            return "Не введены значения последовательности!";
        }
        String message = "Локальные максимумы последовательности: ";
        int[] max_s = Solution10max(nums);
        int[] min_s = Solution10min(nums);
        System.out.print("Локальные максимумы последовательности: ");
        for (int i=0;i < max_s.length;i++)
        {
            System.out.print(max_s[i] + "  ");
            message += (max_s[i] + "  ");
        }

        System.out.print("\nЛокальные минимумы последовательности: ");
        message += "\nЛокальные минимумы последовательности: ";
        for (int i=0;i < min_s.length;i++)
        {
            System.out.print(min_s[i] + "  ");
            message+=(min_s[i] + "  ");
        }
        return message;
    }
    //

    //Вариант 24
    static boolean isTrueSeq(int a, int b) {
        if (Math.abs(a) % 2 == 0)
            return Math.abs(b) % 2 != 0;
        if (Math.abs(b) % 2 == 0)
            return Math.abs(a) % 2 != 0;
        return false;
    }
    static CountIdPair Solution24(int[] arr) {
        int[] res = new int[0];
        int curLength = 0;
        int maxLength = 0;
        int indexBegin = -1;
        boolean isOpenSeq = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (isTrueSeq(arr[i], arr[i + 1])) {
                curLength++;
                isOpenSeq = true;
            } else {
                if (curLength >= maxLength) {
                    maxLength = curLength;
                    indexBegin = i - curLength;
                    curLength = 0;
                    isOpenSeq = false;
                }
            }
        }
        if (isOpenSeq && curLength >= maxLength + 1) {
            indexBegin = arr.length - curLength - 1;
            maxLength = curLength;
        }
        for (int i = indexBegin + 1; i < indexBegin + maxLength + 1; i++) {
            res = Add(res,arr[i]);
        }

        return new CountIdPair(indexBegin,res);
    }
}