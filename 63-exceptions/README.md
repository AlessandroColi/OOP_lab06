System.out.println# Exceptions playground

### Check arguments correctness and throw RuntimeExceptions

Inside the constuctor `ServiceBehindUnstableNetwork(double, int)`,
add a check that the probability is within 0 (included) and 1 (excluded).
If the check fails, it must throw an `IllegalArgumentExeption` with an appropriate message.

### Catch existing exceptions

Implement the methods `UseArithmeticService.retrySendOnNetworkError`
and `UseArithmeticService.retryReceiveOnNetworkError`
as described in the source code.

### Design new exceptions

Create a `NetworkException extends IOException` with two constructors.
The 0-ary constructor must create an Exception whose message is "Network error: no response".
The 1-ary constructor must take a String as input, and create a message "Network error while sending message: <message>"

Modify `ServiceBehindUnstableNetwork.accessTheNework()`
in such a way that it throws the new Exception.
Notice that the blocks that used to catch `IOException` still work.

### Check the arguments' correctness and preserve the stacktrace on rethrows

Modify `ServiceBehindUnstableNetwork.sendData` in such a way that,
instead of printing, throws an IllegalArgumentException with the same message.

**Note:** the newly thrown exception must *preserve* the stacktrace of the original
`NumberFormatException` (which must be set as exception cause).

### Use exceptions to mark exceptional state

Remove all `println`s from `ArithmeticService`: when the system enters an inconsistent state,
an `IllegalStateException` with the same message of the print should be thrown.
Remember to preserve the stacktrace of the cause exceptions if there is any.

### Use `finally` to compute even after the `return`

Modify `ArithmeticService.process()`:
no matter what, once the control flow exits the method,
`commandQueue.clear()` must be executed.

Suggestion: use `finally` appropriately.
