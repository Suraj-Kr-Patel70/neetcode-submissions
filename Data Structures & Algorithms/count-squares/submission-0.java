class CountSquares {

    private HashMap<Integer, HashMap<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());

        HashMap<Integer, Integer> yMap = points.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int result = 0;

        // Try every x-coordinate stored
        for (int x2 : points.keySet()) {

            // Side length
            int d = x2 - x;

            // Same x-coordinate is not useful
            if (d == 0) {
                continue;
            }

            HashMap<Integer, Integer> yMap = points.get(x2);

            // Square above
            result += getCount(x2, y)
                    * getCount(x, y + d)
                    * getCount(x2, y + d);

            // Square below
            result += getCount(x2, y)
                    * getCount(x, y - d)
                    * getCount(x2, y - d);
        }

        return result;
    }

    private int getCount(int x, int y) {

        if (!points.containsKey(x)) {
            return 0;
        }

        return points.get(x).getOrDefault(y, 0);
    }
}