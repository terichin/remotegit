class SequenceCall2 {
	public static void main(String[] args) {
		Sequence2 obj = new Sequence2();
		obj.setNumber1(Integer.parseInt(args[0]));
		obj.setNumber2(Integer.parseInt(args[1]));
		obj.calc();
	}
}