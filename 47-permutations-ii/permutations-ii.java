import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        find(nums, used, new ArrayList<>(), list);
        return list;
    }

    public void find(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> list) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            temp.add(nums[i]);

            find(nums, used, temp, list);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}