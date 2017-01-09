package hobby.Queue;

public class Queues {

	public static void main(String[] args) {
		QueueImpl queueImpl = new QueueImpl();
		QNode node = queueImpl.createQueue();
		node = queueImpl.enqueue(node, 10);
		node = queueImpl.enqueue(node, 5);
		node = queueImpl.enqueue(node, 50);
		node = queueImpl.enqueue(node, 20);
		node = queueImpl.enqueue(node, 40);
		node = queueImpl.enqueue(node, 30);
		node = queueImpl.enqueue(node, 60);
		
		node = queueImpl.dequeue(node);
		node = queueImpl.dequeue(node);
		node = queueImpl.dequeue(node);
		node = queueImpl.dequeue(node);
		node = queueImpl.dequeue(node);
		node = queueImpl.dequeue(node);
		node = queueImpl.dequeue(node);

	}

}

class QueueImpl{
	public QNode createQueue(){
		QNode node = new QNode();
		node.setFront(null);
		node.setRear(null);
		return node;
	}
	
	public QNode newNode(QNode node, int data){
		node.setData(data);
		node.setNext(null);
		return node;
	}
	
	public QNode enqueue(QNode node, int data){
		QNode temp = newNode(node, data);
		if(node.getRear() == null){
			node.setFront(temp);
			node.setRear(temp);
			System.out.println("1Front is::"+node.getFront().getData());
			System.out.println("1Rear is::"+node.getRear().getData());
			return node;
		}
		node.getRear().setNext(temp);
		node.setRear(temp);
		System.out.println("Front is::"+node.getFront().getData());
		System.out.println("Rear is::"+node.getRear().getData());
		return node;
	}
	
	public QNode dequeue(QNode node){
		if(node.getFront() == null){
			return null;
		}
		QNode temp = node.getFront();
		System.out.println("Front being removed::"+temp.getData());
		node.setFront(node.getFront().getNext());
		if(node.getFront() == null){
			node.setRear(null);
		}
		return node;
	}
}

class QNode{
	private int data;
	private QNode next;
	private QNode front;
	private QNode rear;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public QNode getNext() {
		return next;
	}
	public void setNext(QNode next) {
		this.next = next;
	}
	public QNode getFront() {
		return front;
	}
	public void setFront(QNode front) {
		this.front = front;
	}
	public QNode getRear() {
		return rear;
	}
	public void setRear(QNode rear) {
		this.rear = rear;
	}
}