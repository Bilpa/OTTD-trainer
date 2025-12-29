package model

class Piece(var state: PieceState = PieceState.READY) {
}

enum class PieceState {
    READY,
    FOCUSED,
    ACTIVATED,
    PRONE,
    STUNNED,
    DISTRACTED
}