## Бодлогын өгүүлбэр (Монгол)

Танд бүхэл тоо, , ганц бүхэл тоонуудын жагсаалтыг өгөх болно. Та түүний шударга бус байдлыг багасгахын тулд элементүүдээс уртын массив үүсгэх ёстой. Тэр массивыг дууд. Массивын шударга бус байдлыг дараах байдлаар тооцно

Хаана:
- max нь хамгийн том бүхэл тоог илэрхийлдэг
- min нь хамгийн жижиг бүхэл тоог илэрхийлнэ
Жишээ


Дурын хоёр элементийг сонгоно уу.

Бүх хосуудад туршилт хийж, шийдэл нь хамгийн бага шударга бус байдлыг хангадаг.
Тайлбар: Бүхэл тоо нь өвөрмөц биш байж болно.
Функцийн тодорхойлолт
Доорх засварлагчийн maxMin функцийг гүйцээнэ үү.
maxMin дараах параметртэй байна:
int k: сонгох элементийн тоо
int arr[n]:: бүхэл тоонуудын массив
Буцах
int: хамгийн бага боломжит шударга бус байдал
Оролтын формат
Эхний мөрөнд массив дахь элементийн тоо бүхий бүхэл тоо байна.
Хоёр дахь мөрөнд бүхэл тоо байна.
Дараагийн мөр бүр нь бүхэл тоог агуулна.
Хязгаарлалт



Жишээ оролт 0
7
3
10
100
300
200
1000
20
30
Жишээ гаралт 0
20
Тайлбар 0
Энд; бүхэл тоог сонгоход шударга бус байдал тэнцүү байна
max(10,20,30) - min(10,20,30) = 30 - 10 = 20
Жишээ оролт 1
10
4
1
2
3
4
10
20
30
40
100
200
Жишээ гаралт 1
3
Тайлбар 1
Энд; бүхэл тоог сонгоход шударга бус байдал тэнцүү байна
max(1,2,3,4) - мин(1,2,3,4) = 4 - 1 = 3
Жишээ оролт 2
5
2
1
2
1
2
1
Жишээ гаралт 2
0
Тайлбар 2
Энд. эсвэл хамгийн бага шударга бус байдлыг өгнө.





## Холбоос

https://www.hackerrank.com/challenges/angry-children/problem?isFullScreen=true





## Нотолгоо, тайлбар

Доорх код нь `maxMin` гэдэг функцийн шийдэл бөгөөд өгөгдсөн `n` ширхэг бүхэл тооноос `k` ширхэгийг сонгон авч, **хамгийн бага unfairness** буюу `(хамгийн их утга - хамгийн бага утга)` хамгийн бага байх сонголтыг хайж олоход зориулагдсан.

*Нотолгоо ба тайлбар (Тайлбар бүхий код)**

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /**
     * Функцийн зорилго:
     * Өгөгдсөн бүхэл тоонуудын жагсаалаас k ширхэг дараалсан тоог сонгон авч,
     * тэдгээрийн хамгийн их болон хамгийн бага утгын зөрүү буюу "unfairness"-ийг тооцно.
     * Үүний хамгийн бага утгыг олно.
     */
    public static int maxMin(int k, List<Integer> arr) {
        // Жагсаалтыг өсөх дарааллаар эрэмбэлнэ.
        Collections.sort(arr);

        // Unfairness-ийн хамгийн бага утгыг хадгалах хувьсагч.
        int minUnfairness = Integer.MAX_VALUE;

        // Жагсаалтын бүх k-тай цонхоор гүйж харна.
        for (int i = 0; i <= arr.size() - k; i++) {
            // i-оос эхлээд дараалсан k элементийн хамгийн их, хамгийн бага ялгавар
            int unfairness = arr.get(i + k - 1) - arr.get(i);

            // Хамгийн бага unfairness-г хадгална
            minUnfairness = Math.min(minUnfairness, unfairness);
        }

        // Эцэст нь хамгийн бага unfairness-г буцаана.
        return minUnfairness;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Input унших хэсэг
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Элементүүдийн тоо
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Сонгох k элементийн тоо
        int k = Integer.parseInt(bufferedReader.readLine().trim());

        // Бүхэл тоонуудыг лист болгон уншиж авна
        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

        // Хамгийн бага unfairness-г тооцоолно
        int result = Result.maxMin(k, arr);

        // Гаргасан үр дүнг бичнэ
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        // Ресурсуудыг хаана
        bufferedReader.close();
        bufferedWriter.close();
    }
}
```

---

 Жишээ:

Жишээ оролт:

```
n = 7
k = 3
arr = [10, 100, 300, 200, 1000, 20, 30]
```

Энэ үед:

1. Жагсаалтыг эрэмбэлнэ:
   `arr = [10, 20, 30, 100, 200, 300, 1000]`
2. Дараалсан `k = 3` багцуудаас хамгийн бага зөрүүтэйг сонгоно:

   * `[10, 20, 30] → 30 - 10 = 20`
   * `[20, 30, 100] → 100 - 20 = 80`
   * ...
3. `minUnfairness = 20` (хамгийн бага зөрүүтэй багц)

---

 Нотолгоо:

* Өгөгдсөн массивыг `сортлох` нь шалтгаантай: зөвхөн **дараалсан k элементийн** дундах ялгавар хамгийн бага байж болно.
* Бүх боломжит `k` урттай дараалсан блокыг шалгаснаар `O(n log n)` сорт + `O(n)` гүйлт = **үнэмлэхүй оптималь шийдэл**.