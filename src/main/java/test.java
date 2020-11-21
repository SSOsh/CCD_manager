class test {
    public static void main(String[] args) {
        String url = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbsonsh53641858001";
        String queryType = "Bestseller";
        int start = 1;
        int MaxResults = 50;

        String result = url + "&queryType=" + queryType + "&start=" + start + "&MaxResults" + MaxResults;

    }
}