class SequenceCall1 {
	public static void main(String[] args) {
		Sequence1 obj = new Sequence1();
		obj.setMessage(args[0]);
		String message = obj.getMessage();
		System.out.println(message);
	}
}