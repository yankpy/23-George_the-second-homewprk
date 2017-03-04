
public class Factory {
	public static NvWa createPerson(String p)throws Exception {
		if(p.equalsIgnoreCase("M")){
			return new Man();
		}
		else if(p.equalsIgnoreCase("W")){
			return  new Woman();
		}
		else if(p.equalsIgnoreCase("R")){
			return new Robot();
		}
		else{
			throw new Exception("女娲请输入正确的制造目标。");
		}
	}
}
