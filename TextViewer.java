package hw4;

/**
 * A TextViewer prints information about the Shapes to the console,
 * updates whenever a level is changed
 * 
 * @author Juan
 *
 */
public class TextViewer implements View {
	
	@SuppressWarnings("unused")
	private DrawingModel model;
	
	/**
	 * Updates the current model,
	 * prints Shape information to console
	 * 
	 * @param model The updated DrawingModel
	 */
	@Override
	public void update(DrawingModel model) {
		
		this.model = model;
		
		if (model.getShapes() != null) {
		
			for (Shape s: model.getShapes()) {
			
				System.out.println(s);
			}
			
			System.out.println("\n");
		}
	}
}
