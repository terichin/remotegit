class DownCastInfExeSample {
    public static void main(String[] args) {
        InfSample inf1 = new DownCastInfObjSample();
        DownCastInfObjSample obj = (DownCastInfObjSample) inf1;
        obj.sayHello();
    }
}