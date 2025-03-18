static Map<Integer, Integer> countElements(List<Integer> list) {
    list.countBy { it }
}

static void printResult(Map<Integer, Integer> result) {
    println result.collect { k, v -> "$k : $v" }.join(", ")
}

static void main(String[] args) {
    def list = [1, 3, 4, 5, 1, 5, 4]
    def result = countElements(list)
    printResult(result)
}