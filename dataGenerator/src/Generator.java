public class Generator {
    public static void main(String[] args) {
        int i;
        for(i = 11; i<100000; i++){
            System.out.println("INSERT INTO dbtocsvdata(id,firstName,lastName,email) VALUES(" + i +", 'Nazmul"+i+"','Khan','nazmul"+i+"@gmail.com');");
        }
    }
}
