import java.util.function.Supplier;

class Synthax {

    public static void main(String[] args){
    	statements();
        controlFlow();
        exceptions();
    }

    public static void statementsOnSameLine(){
        int x = 0;
        foo("hi", foo("ok", 1, x+25), ++x);

        for(int i=0; i<10; ++i){

        }

    }

    public static void statements(){
        // assignements
        int x = 0;
        int a=0, b=1; int c=2+a*b%4;
        int y = x==b ? 10 : 20;

        //functions call
        foo("ok", 1, 2);
        foo("not ok", foo("ok", 1, 5+10), 20-50);

        //object
        Foo f = new Foo("ok", 25);
        f.a = "???";
        f.foo(5);
        f.bar();

        //lambdas
        Supplier<Integer> g = () -> {
            return 2;
        }; 
        g.get();
    }

    public static void controlFlow(){

        int x = 10;

        if(x%2==0){
            System.out.println("aaaa");
        }else{
            System.out.println("bbbb");
        }

        //add switch

        int a = 0;
        while(a<10){
            a+=1;
            if(a==3){
                continue;
            }
            if(a==5){
                break;
            }
        }

        int b = 0;
        for(int i=0; i<10; ++i){
            b+=1;
        }
    }

    public static void exceptions(){
        try{
            throw new Exception("not ok");
        }catch(Exception e){
            System.out.println("not ok");
        }finally{
            System.out.println("finally");
        }
        //add try with resources

    }



    static class Foo {
        String a;
        int b;

        public Foo(String a, int b){
            this.a=a;
            this.b=b;
        }

        public void foo(int b){
            this.b=b;
        }

        public String bar(){
            return a;
        }
    }

    public static int foo(String x, int a, int b){
        if(x.equals("ok")){
            return a+b;
        }else{
            return a;
        }
    }

}
