package programowanie1.binarytree;

public class Tree {
    private Node root;
    private int max;


    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void viewHorizontal(){
        this.max= getTreeMaxLevel(root);//liczba pozimow
        for (int i=0;i<this.max;i++) {
            if(i==0) {

                System.out.println(root.getData());//wyswietl korzen
                continue;
            }
            viewNode(root,0,i);/// wyswietlaj poszczegolne poziomy
            System.out.println();
        }

    }

    public void viewNode(Node node, int curentLevel, int printLevel){
        curentLevel++;//kolejny nizszy level
        if(node!=null) {//idz dalej gdy sa wezly
            if (curentLevel == printLevel) {//gdy jestesmy na dobrym levelu
                if (node.getLeft() != null) {//wyswitel lewy
                    System.out.print(node.getLeft().getData());
                } else {
                    System.out.print("*");
                }
                if (node.getRight() != null) {//wyswietl prawy
                    System.out.print(node.getRight().getData());
                } else {
                    System.out.print("*");
                }
            } else {//wejdz glebiej gdy to nie ten level
                viewNode(node.getLeft(), curentLevel, printLevel);
                viewNode(node.getRight(), curentLevel, printLevel);
            }
        }else{//wyswietlaj puste wezly
            if (curentLevel == printLevel) {//gdy jestesmy na dobrym levelu wyswietl puste miejsca
                System.out.print("*");
                System.out.print("*");
            } else {//wejdz glebiej gdy to nie ten level
                viewNode(node, curentLevel, printLevel);
                viewNode(node, curentLevel, printLevel);
            }
    }


    }

    public int getTreeMaxLevel(Node root){//znajdz najdluzsza droge(liczba poziomow)
        int levelLeft=0,levelRight=0;
        //zakoncz zeby nie było wywołania metody z nieistniejacego obiektu
        if (root==null) return 0;

        //tzw listek wiec zwracamy 1 poziom
        if (root.getLeft()==null && root.getRight()==null) return 1;

        //licz poziomy w lewym
        if (root.getLeft()!=null){
            levelLeft=getTreeMaxLevel(root.getLeft());
        }
        //licz poziomy w prawym
        if (root.getRight()!=null){
            levelRight=getTreeMaxLevel(root.getRight());
        }
        //zwracamy w ktorym bylo wiecej i zwiekszone o 1
        if(levelLeft>levelRight) return ++levelLeft;
        else return ++levelRight;

    }


    public void viewVertical(Node root, int space)
    {
        if (root == null) return;
        space += 1;//zwiekszanie odleglosci w poszczegolnych levelach

        viewVertical(root.getRight(), space);//prawe najpierw

        for (int i = 1; i < space; i++)  System.out.print(" "); // spacje

        System.out.print(root.getData() + "\n");

        viewVertical(root.getLeft(), space);//potem lewe
    }

    public void viewVertical(Node root)
    {
        viewVertical(root, 0);
    }

}
