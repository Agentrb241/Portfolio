#ifndef __ABS_H__
#define __ABS_H__

#include "Decorator.h"
#include "base.h"


class Absolute : public Decorator {
    public:
        /* Constructors */
       Absolute(Base* x);

        std::string stringify();
        double evaluate();
};

#endif
