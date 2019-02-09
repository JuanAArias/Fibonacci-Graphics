package hw4;


/**
 * Able to receive data from the model
 * @author Juan.Arias
 *
 */
public interface View {
	/**
	 * Send the data of the model to the view
	 */
	void update(DrawingModel model);
}