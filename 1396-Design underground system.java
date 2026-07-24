class UndergroundSystem {
    Map<Integer, Object[]> checkInMap;
    Map<String, double[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] checkInInfo = checkInMap.remove(id);
        String startStation = (String) checkInInfo[0];
        int startTime = (int) checkInInfo[1];

        String route = startStation + "->" + stationName;
        double duration = t - startTime;

        travelMap.putIfAbsent(route, new double[]{0, 0});
        travelMap.get(route)[0] += duration;
        travelMap.get(route)[1] += 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        double[] data = travelMap.get(route);
        return data[0] / data[1];
    }
}
