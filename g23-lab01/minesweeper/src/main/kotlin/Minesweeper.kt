data class MinesweeperBoard(val board: List<String>) {

    fun withNumbers(): List<String> {
        val numberedBoard = this.board.map{it.toCharArray()};
        for(i in 0..numberedBoard.size-1){
            for(j in 0..numberedBoard.first().size-1){
                var count = 0;
                if(numberedBoard[i][j]==' '){
                    if(i+1<numberedBoard.size && numberedBoard[i+1][j]=='*')
                        count++;
                    if(i-1>=0 && numberedBoard[i-1][j]=='*')
                        count++;
                    if(j+1<numberedBoard.first().size && numberedBoard[i][j+1]=='*')
                        count++;
                    if(j-1>=0 && numberedBoard[i][j-1]=='*')
                        count++;
                    if(i+1<numberedBoard.size && j+1<numberedBoard.first().size && numberedBoard[i+1][j+1]=='*')
                        count++;
                    if(i+1<numberedBoard.size && j-1>=0 && numberedBoard[i+1][j-1]=='*')
                        count++;
                    if(i-1>=0 && j-1>=0 && numberedBoard[i-1][j-1]=='*')
                        count++;
                    if(i-1>=0 && j+1<numberedBoard.first().size && numberedBoard[i-1][j+1]=='*')
                        count++;

                    if(count>0)
                        numberedBoard[i][j]=count.toString().single();
                }
            }
        }
        return numberedBoard.map{String(it)};
    }
}
