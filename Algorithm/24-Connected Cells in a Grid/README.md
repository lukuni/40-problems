## Бодлогын өгүүлбэр (Монгол)

Нүд бүр нь a эсвэл a агуулсан матрицыг авч үзье. a агуулсан аливаа нүдийг дүүргэсэн нүд гэж нэрлэдэг. Хоёр нүд нь хэвтээ, босоо, диагональ зэрэгтэй зэрэгцэн оршдог бол холбогдсон гэж нэрлэдэг. Дараах сүлжээнд X тэмдэглэгдсэн бүх нүднүүд Y тэмдэглэгдсэн нүдтэй холбогдсон байна.
XXX
XYX
XXX
Хэрэв нэг буюу хэд хэдэн дүүрсэн нүд холбогдсон бол тэдгээр нь бүсийг үүсгэдэг. Бүс нутгийн нүд бүр тухайн бүсийн тэг буюу түүнээс олон нүдтэй холбогдсон боловч тухайн бүсийн бусад бүх нүдтэй шууд холбогдох албагүй гэдгийг анхаарна уу.
Матриц өгөгдсөн бол матрицын хамгийн том муж дахь нүдний тоог олоод хэвлэ. Матрицад нэгээс олон бүс байж болохыг анхаарна уу.
Жишээлбэл, дараах матрицад хоёр муж байна. Зүүн дээд талд байгаа том хэсэг нь нүднүүдийг агуулна. Баруун доод талд байгаа жижиг нь .
110
100
001
Функцийн тодорхойлолт
Доорх засварлагчийн connectCell функцийг гүйцээнэ үү.
connectCell нь дараах параметртэй байна:
- int матриц[n][m]: матрицын мөрийг илэрхийлнэ
Буцах
- int: хамгийн том бүсийн талбай
Оролтын формат
Эхний мөрөнд бүхэл тоо, матриц дахь мөрийн тоог агуулна.
Хоёр дахь мөрөнд матриц дахь баганын тоо бүхий бүхэл тоо байна.
Дараагийн мөр бүр нь зайгаар тусгаарлагдсан бүхэл тоонуудыг агуулна.
Хязгаарлалт

Жишээ оролт
STDIN функц
----- --------
4 n = 4
4 м = 4
1 1 0 0 тор = [[1, 1, 1, 0], [0, 1, 1, 0], [0, 0, 1, 0], [1, 0, 0, 0]]
0 1 1 0
0 0 1 0
1 0 0 0
Жишээ гаралт
5
Тайлбар
Доорх диаграмм нь матрицын хоёр бүсийг дүрсэлсэн байна. Холбогдсон бүсүүдийг X эсвэл Y-ээр дүүргэсэн. Тодорхой болгохын тулд тэгийг цэгээр сольсон.
X X. .
. X X.
. . X .
Y . . .
Том бүс нь X гэж тэмдэглэгдсэн эсүүдтэй.





## Холбоос

https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem?isFullScreen=true





## Нотолгоо, тайлбар
Кодын зорилго:

Матриц (2D хүснэгт) дотор 1 гэсэн утгатай нүднүүд хоорондоо хөндлөн, босоо болон диагональ чиглэлд холбогдож байвал эдгээрийг нэг "region" буюу бүс гэж үзнэ. Програмын зорилго бол хамгийн олон 1 агуулсан холбоотой бүсийн хэмжээг олох юм.

 1. dx, dy массивууд:

static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
Эдгээр нь матрицын 8 зүг чиглэлд (зүүн дээд, дээд, баруун дээд, зүүн, баруун, зүүн доод, доод, баруун доод) шилжихэд хэрэглэгддэг.

 2. connectedCell() функц:

public static int connectedCell(List<List<Integer>> matrix)
Энэ функц дараах үйлдлийг хийнэ:

Матрицыг шалгана (хоосон эсэх).

Матрицын бүх 1-үүдийг шалгана.

Шалгаж амжаагүй 1-ээс эхлэн bfs() функц дуудаж холбоотой бүсийг хайна.

Хамгийн том холбоотой бүсийн хэмжээг хадгална.

 3. bfs() функц:

private static int bfs(...)
Энэ функц нь:

BFS (Breadth-First Search) буюу өргөн хүрээний хайлт ашиглан тухайн 1-ээс эхэлж бусад холбогдсон 1-үүдийг олно.

Бүх хамаарал бүхий нүднүүдийг шалгаж, visited[][] массивд тэмдэглэнэ.

Холбоотой бүсийн нүдний тоог (size) тоолж буцаана.

 4. main() функц:

public static void main(String[] args)
Энэ нь:

Оролтын өгөгдлийг (матрицын хэмжээ ба өгөгдөл) уншина.

Матрицыг List<List<Integer>> хэлбэрээр үүсгэнэ.

connectedCell() функцийг дуудаж хариуг System.out.println()-аар хэвлэнэ.

 Жишээ:

Оролт:
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

Гаралт:
5
Тайлбар: Матриц дотор 1-үүдийн хамгийн том холбоотой хэсэг нь 5 ширхэг 1-тэй (диагональ болон хажуу талаараа холбогдсон).

