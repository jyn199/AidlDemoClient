/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\work\\Workspaces\\EclipseAndroid\\AidlDemoClient\\src\\com\\jyn\\aidl\\Demo.aidl
 */
package com.jyn.aidl;
public interface Demo extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.jyn.aidl.Demo
{
private static final java.lang.String DESCRIPTOR = "com.jyn.aidl.Demo";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.jyn.aidl.Demo interface,
 * generating a proxy if needed.
 */
public static com.jyn.aidl.Demo asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.jyn.aidl.Demo))) {
return ((com.jyn.aidl.Demo)iin);
}
return new com.jyn.aidl.Demo.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getDemo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDemo();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.jyn.aidl.Demo
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getDemo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDemo, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getDemo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.lang.String getDemo() throws android.os.RemoteException;
}
