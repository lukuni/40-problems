## Бодлогын өгүүлбэр (Монгол)

Хаалт нь дараах тэмдэгтүүдийн аль нэг нь гэж тооцогддог: (, ), {, }, [, эсвэл ].
Хэрэв нээх хаалт (жишээ нь, (, [, эсвэл {) яг ижил төрлийн хаалтын хаалт (жишээ нь, ), ], эсвэл }) зүүн талд байвал хоёр хаалт нь тохирох хос гэж тооцогддог. Гурван төрлийн тохирох хос хаалт байдаг: [], {}, ().
Тохирох хос хаалтууд нь тохирохгүй байвал тэнцвэргүй болно. Жишээлбэл, {[(])} нь { болон } хоорондох контентууд тэнцвэртэй биш учир тэнцвэртэй биш байна. Хос дөрвөлжин хаалт нь дан, тэнцвэргүй нээх хаалт, (, хос хаалт нь дан, тэнцвэргүй хаалтын дөрвөлжин хаалт, ]-г хавсаргана.
Энэ логикоор бид дараах нөхцлүүдийг хангасан тохиолдолд хаалтны дарааллыг тэнцвэртэй гэж хэлж байна.
Энэ нь тохирохгүй хаалт агуулаагүй болно.
Тохиромжтой хос хаалтанд багтсан дэд олонлог нь мөн тохирох хос хаалт юм.
Өгөгдсөн хаалтуудын дараалал бүр тэнцвэртэй эсэхийг тодорхойлно уу. Хэрэв мөр тэнцвэртэй байвал YES гэж буцаана. Үгүй бол NO гэж буцаана уу.
Функцийн тодорхойлолт
Доорх засварлагчийн isBalanced функцийг гүйцээнэ үү.
isBalanced нь дараах параметртэй байна:
string s: хаалтны мөр
Буцах
мөр: YES эсвэл ҮГҮЙ
Оролтын формат
Эхний мөрөнд нэг бүхэл тоо, мөрийн тоог агуулна.
Дараагийн мөр бүр нь нэг мөр, хаалтны дарааллыг агуулна.
Хязгаарлалт

, дарааллын урт хаана байна.
∈ { {, }, (, ), [, ] } дарааллын бүх тэмдэгтүүд.
Гаралтын формат
Мөр бүрийн хувьд YES эсвэл ҮГҮЙ гэж буцаана.
Жишээ оролт
STDIN функц
----- --------
3 n = 3
{[()]} эхний s = '{[()]}'
{[(])} секунд s = '{[(])}'
{{[[(())]]}} гурав дахь нь ='{{[[(())]]}}'
Жишээ гаралт
ТИЙМ
ҮГҮЙ
ТИЙМ
Тайлбар
{[()]} мөр нь тэнцвэртэй мөр байх хоёр шалгуурыг хангасан.
{[(])} мөр тэнцвэртэй биш учир нь тохирох { болон } хосоор хаагдсан хаалт тэнцвэргүй байна: [(]).
{{[[(())]]}} мөр нь тэнцвэртэй мөр байх хоёр шалгуурыг хангасан.




## Холбоос

https://www.hackerrank.com/challenges/balanced-brackets/problem?isFullScreen=true




## Нотолгоо, тайлбар

`Solution` класст зориулсан бүрэн ажиллах кодыг доор бэлдлээ. `isBalanced` функц дотор stack ашиглаж, дээр тайлбарласан логикоор шийдсэн болно.

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return "NO";

                char top = stack.pop();
                if (ch == ')' && top != '(') return "NO";
                if (ch == ']' && top != '[') return "NO";
                if (ch == '}' && top != '{') return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter output to stdout since environment variable OUTPUT_PATH may not be set.
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
```

---

### Хэрэглээ:

* Эхлээд утга оруулна — `t` ширхэг мөр орно (жишээ: 3).
* Дараа нь `t` ширхэгт тохирсон тэгшлэгийн тэмдэгтүүд орно.
* Хариуд бүрд нь `YES` эсвэл `NO` гарна.

 Жишээ:

*Оролт:**

```
3
{[()]}
{[(])}
{{[[(())]]}}
```

*Гаралт:**

```
YES
NO
YES
```
