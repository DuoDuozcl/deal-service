import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, Merchandise> commoditiesList = new HashMap<>();

    public static void main(String[] args) {
        int id = 1;
        while (true) {
            System.out.println("请输入数字选择操作：\n\t1、新建商品\n\t2、修改商品\n\t3、删除商品\n\t4、展示商品\n\t输入0结束程序。");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt()) {
                System.out.println("请输入数字！");
                continue;
                
            }
            int num = input.nextInt();
            if (num == 0) break;
            switch (num) {
                case 1:
                    CreteProducts(id++);
                    break;
                case 2:
                    System.out.println("可进行修改的商品名称：");
                    ShowName();
                    EditProducts();
                    break;
                case 3:
                    System.out.println("可删除的商品名称：");
                    ShowName();
                    DeleteProducts();
                    break;
                case 4:
                    ShowProducts();
                    break;
                default:
                    System.out.println("请输入合法的数字");
            }
        }
    }

    public static void CreteProducts(int number) {
        Merchandise m = new Merchandise();
        System.out.println("请输入商品名称");
        m.name = new Scanner(System.in).nextLine();
        while (true) {
            System.out.println("请输入一个整数作为商品价格");
            Scanner input_price = new Scanner(System.in);
            if (input_price.hasNextInt()) {
                m.price = input_price.nextInt();
                break;
            }
            System.out.println("输入的不是整数，请重新输入");
        }
        System.out.println("请输入商品描述");
        m.description = new Scanner(System.in).nextLine();
        m.id = "id" + number;
        commoditiesList.put(m.name, m);
        System.out.println("新建商品" + m.name + "成功");
    }

    public static void EditProducts() {
        System.out.println("请输入需要修改的商品名称");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (!commoditiesList.containsKey(name)) {
            System.out.println("商品不存在");
            return;
        }
        Merchandise m = commoditiesList.get(name);
        while (true) {
            System.out.println("请选择要修改的属性：\n\t1、商品名称\n\t2、商品价格\n\t3、商品描述\n\t输入0结束修改。");
            boolean flag = true;
            if (!input.hasNextInt()) {
                System.out.println("请输入数字！");
                continue;
            }
            int num = input.nextInt();
            if (num == 0) break;
            switch (num) {
                case 1:
                    System.out.println("请输入修改后的名称");
                    m.name = new Scanner(System.in).nextLine();
                    break;
                case 2:
                    while (true) {
                        System.out.println("请输入修改后的价格");
                        Scanner input_price = new Scanner(System.in);
                        if (input_price.hasNextInt()) {
                            m.price = input_price.nextInt();
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入修改后的描述");
                    m.description = new Scanner(System.in).nextLine();
                    break;
                default:
                    System.out.println("请输入合法的数字");
                    flag = false;
            }
            commoditiesList.put(name, m);
            if (flag) System.out.println("修改完成");
        }
    }

    public static void DeleteProducts() {
        System.out.println("请输入需要删除的商品名称");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (!commoditiesList.containsKey(name)) {
            System.out.println("商品不存在");
            return;
        }
        commoditiesList.remove(name);
        System.out.println("商品" + name + "删除成功");
    }

    public static void ShowProducts() {
        HashMap<String, Merchandise> com = commoditiesList;
        System.out.println("现有商品列表:\n\t商品名称\t商品价格\t商品描述");
        for (String name : com.keySet()) {
            Merchandise m = com.get(name);
            System.out.println("\t" + m.name + "\t" + m.price + "\t" + m.description);
        }
    }
    public static void ShowName() {
        HashMap<String, Merchandise> com = commoditiesList;
        StringBuffer ret = new StringBuffer();
        for (String name : com.keySet()) {
            ret.append(name+"\t");
        }
        System.out.println(ret);
    }
}
