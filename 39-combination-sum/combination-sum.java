import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        find(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    public void find(int[] arr, int target, int index, List<Integer> temp, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        if (index == arr.length || target < 0)
            return;

        temp.add(arr[index]);
        find(arr, target - arr[index], index, temp, list);

        temp.remove(temp.size() - 1);
        find(arr, target, index + 1, temp, list);
    }
}