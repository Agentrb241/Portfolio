#ifndef SUB_H
#define SUB_H

#include <string>
#include <sstream>
#include "base.h"
#include "iterator.hpp"


class Sub {
public:
        Sub();
        Sub(Base *left, Base *right);
        double evaluate();
        std::string stringify();
//        Base* get_left();
  //      Base* get_right();
    //    Iterator* create_iterator();
      //  void accept(CountVisitor* visitor);
private:
        Base *left;
        Base *right;
};

#endif
