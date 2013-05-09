package dk.iensenfirippu.jrpg.wsclient;

public interface OnAsyncTaskCompleteListener<T>
{
    /**
     * Callback method that get invoked when the web service task is successfully completed.
     * 
     * @param result
     */
    void onTaskCompleteSuccess(T result);

    /**
     * Callback method that get invoked if the task failed.
     * 
     * @param cause
     *            {@link Exception} describing the cause for the failure
     */
    void onTaskFailed(Exception cause);
}
