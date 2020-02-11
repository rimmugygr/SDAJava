package programowanie1.steam_sort;



import programowanie1.steam_sort.pojo.Thing;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Thing> lista=Thing.init();

        lista.add(new Thing("aaa","bbb",6));
//        for (Thing thing : lista) {
//            System.out.println(thing.toString());
//        }
        lista.stream()
                .forEach(p->System.out.println(p.toString()));

        System.out.println(">>>filtr<<<");
//        lista.stream().filter(o->o.getAge()>5).forEach(p->System.out.println(p.toString()));
        lista.stream()
                .filter(o-> {
                return o.getAge() > 5;
                })
                .forEach(p->System.out.println(p.toString()));
        lista.stream()
                .filter(Thing::isOlderThan5).forEach(Thing::view);



        System.out.println(">>>sortowanie<<<");
        lista.stream()
                .sorted((Thing p1, Thing p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList())
                .stream().forEach(Thing::view);

        System.out.println(">>>sortowanie<<<");
        lista.stream()
                .sorted(Comparator.comparing(Thing::getPesel))
                .collect(Collectors.toList())
                .stream().forEach(Thing::view);

        System.out.println(">>> sortowanie <<<");
        Comparator<Thing> comparator=null;
        comparator = Comparator.comparing(Thing::getName);
        lista.stream()
                .sorted(comparator)
                .collect(Collectors.toList())
                .stream().forEach(Thing::view);

        System.out.println(">>> sortowanie 2 poziomy <<<");

        lista.stream()
                .sorted(Comparator.comparing(Thing::getAge).thenComparing(Thing::getPesel))
                .collect(Collectors.toList())
                .stream().forEach(Thing::view);

       ;


        System.out.println(">>>strumin intow<<<");
        IntStream.range(0,7).forEach(o->System.out.println(o));

        System.out.println(">>>steam on another steam<<<");
        List<String> aaaa=lista.stream()
                .flatMap(p-> Arrays.asList(p.getName(),p.getPesel(),String.valueOf(p.getAge())).stream())
                .collect(Collectors.toList());
        aaaa.forEach(x->System.out.println(x));
        System.out.println(">>>steam on another steam 2<<<");
        lista.stream()
                .flatMap(p-> Arrays.asList(p,p.getPesel(),p.getAge()).stream())
                .forEach(x->{
                    if (x instanceof Thing) ((Thing) x).view();
                    if (x instanceof String) System.out.println((String) x);
                    if (x instanceof Integer) System.out.println((Integer) x);
                });



        //sortowanie z comparatorem na lambdzie v1
        lista.clear();
        lista=Thing.init();
        lista.sort(Comparator.comparing(Thing::getAge).thenComparing(Thing::getName));
        lista.forEach(x->System.out.println(x));

        //sortowanie z comparatorem na lambdzie v2
        lista.clear();
        lista=Thing.init();
        lista.sort((Thing t1,Thing t2)->{
            if((t1.getAge()-t2.getAge())==0){
                return t1.getName().compareTo(t2.getName());
            }
            return t1.getAge()-t2.getAge();
        });
        lista.forEach(x->System.out.println(x));
    }
}
