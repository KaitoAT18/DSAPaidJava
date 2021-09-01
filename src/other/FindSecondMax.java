package other;

public class FindSecondMax {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6, 5, 4, 7, 8, 9, 9, 8, 9, 7, 8, 5, 6, 4, 2, 1, 3};
        int[] arr1 = new int[]{1, 1, 1, 1, 1, 1, 1, 5};
        var max = findMax(arr1); // thay arr => ok
        var secondMax = findSecondMax(arr1, max);
        if (secondMax == max) {
            System.out.println("Không có giá trị lớn thứ 2");
        } else {
            System.out.println("Giá trị lớn nhất: " + max);
            System.out.println("Giá trị lớn nhì: " + secondMax);
        }
    }

    private static int findSecondMax(int[] arr, int max) {
        int secondMax = max;
        // tìm giá trị đầu tiên khác max
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                secondMax = arr[i];
                break;
            }
        }
        // tìm max2
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    private static int findMax(int[] arr) {
        var max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}