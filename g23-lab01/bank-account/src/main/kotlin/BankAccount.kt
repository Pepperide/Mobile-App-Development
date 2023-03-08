class BankAccount {
    // TODO: implement read access to 'balance'
    var balance:Long = 0
        get() {
            if(this.isClosed){
                throw IllegalStateException()
            }
            return field
        }
    var isClosed = false;

    @Synchronized
    fun adjustBalance(amount: Long){
        if(isClosed){
            throw IllegalStateException()
        }
        this.balance+=amount
    }

    fun close() {
        this.isClosed=true;
    }
}
