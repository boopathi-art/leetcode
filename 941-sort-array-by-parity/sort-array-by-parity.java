class Solution {
    public int[] sortArrayByParity(int[] arr) {

        int left = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0) {

                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;

                left++;
            }
        }

        return arr;
    }
}