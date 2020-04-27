// Game
// The traditional 8x8 chess board with pieces.

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

#include "game.hpp"
#include "../../joueur/src/base_ai.hpp"
#include "../../joueur/src/any.hpp"
#include "../../joueur/src/exceptions.hpp"
#include "../../joueur/src/delta.hpp"
#include "game_object.hpp"
#include "player.hpp"
#include "impl/chess.hpp"

#include <iostream>
#include <cctype>
#include <type_traits>

namespace cpp_client
{

namespace chess
{

void Game_::print() {
  std::string FEN = fen;
  char i_file='a';
  int i_rank=8;
  const int Wid_Hgh=8;

  for(int i=0; i<Wid_Hgh+1; i++) {
    std::cout << "+---";
  }
  std::cout << "+\n|  ";
  for(int i=0; i<Wid_Hgh; i++) {
    std::cout << " | " << (char)(i_file+i); 
  } 
  std::cout << " |\n";
  for(int i=0; i<Wid_Hgh+1; i++) {
    std::cout << "+---";
  }
  std::cout << "+\n";
  std::cout << "| " << i_rank;

  int cnt=1;
  for(auto c : FEN) {
    if(isalpha(c)) {
      std::cout << " | " << c;
    } else if(isdigit(c)) {
      for(char k=c; k>'0'; k--) {
        std::cout << " |  ";
      }
    } else if(c=='/') {
      std::cout << " |\n"; 
      for(int i=0; i<Wid_Hgh+1; i++) {
        std::cout << "+---";
      }
      std::cout << "+\n";
      std::cout << "| " << i_rank-cnt++;
    } else if(c==' ') {
      break;
    }
  }
  std::cout << " |\n";
  for(int i=0; i<Wid_Hgh+1; i++) {
    std::cout << "+---";
  }
  std::cout << "+\n";
}

} // chess

} // cpp_client
