import ru.baROM.pr1.Figure;
import ru.baROM.pr1.Square;
import ru.baROM.pr1.Triangle;
import ru.baROM.pr1.Сircle;

import java.util.Arrays;
import java.util.List;

public class test_1_3 {

    public static void main(String[] args) {

        Figure circle = new Сircle();
        Figure square = new Square();
        Figure triangle = new Triangle();

        List<Figure> figures = Arrays.asList(circle, square, triangle);

        for (Figure f: figures) {
            f.whuAm();
        }
    }
}
