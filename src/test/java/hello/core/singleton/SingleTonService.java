package hello.core.singleton;

public class SingleTonService {
    private static final SingleTonService instance = new SingleTonService();

    private SingleTonService(){

    }

    public static SingleTonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 서비스 로직입니다.");
    }

}
