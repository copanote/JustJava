package state;

public class NightState implements State {
	private static NightState singleton = new NightState();
	private NightState() {}
	
	public static State getInstance() {
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		if ( 9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("���: �߰��ݰ� ���!");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(�߰�)");
	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("�߰���ȭ ����");
	}
	
	public String toString() {
		return "[�߰�]";
	}

}
