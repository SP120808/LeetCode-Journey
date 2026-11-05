import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    public void find(int[] arr, int target, int index, List<Integer> temp, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;

            if (arr[i] > target)
                break;

            temp.add(arr[i]);
            find(arr, target - arr[i], i + 1, temp, list);
            temp.remove(temp.size() - 1);
        }
    }
}