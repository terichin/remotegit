class AccsaUseSample2 {
    public static void main(String args[]){
        AccsaSample2 as2 = new AccsaSample2();
        InfSample obj = new InfUseSample();
        as2.setObject(obj);
        InfSample obj2 = as2.getObject();
        obj2.print();
    }
}