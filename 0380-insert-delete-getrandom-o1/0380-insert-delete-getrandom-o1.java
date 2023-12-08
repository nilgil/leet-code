class RandomizedSet {

  private final List<Integer> nums = new ArrayList<>();
  private final Map<Integer, Integer> map = new HashMap<>();

  public RandomizedSet() {
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) return false;
    map.put(val, nums.size());
    nums.add(val);
    return true;
  }

  public boolean remove(int val) {
    Integer idx = map.get(val);
    if (idx == null) return false;
    if (idx < nums.size() - 1) {
      Integer last = nums.get(nums.size() - 1);
      nums.set(idx, last);
      map.put(last, idx);
    }
    nums.remove(nums.size() - 1);
    map.remove(val);
    return true;
  }

  public int getRandom() {
    return nums.get((int)(Math.random() * nums.size()));
  }
}
