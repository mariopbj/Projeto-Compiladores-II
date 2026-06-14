// Generated from grammar/MiniLangParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLangParser}.
 */
public interface MiniLangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MiniLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MiniLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(MiniLangParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(MiniLangParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void enterListDecl(MiniLangParser.ListDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void exitListDecl(MiniLangParser.ListDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#declTip}.
	 * @param ctx the parse tree
	 */
	void enterDeclTip(MiniLangParser.DeclTipContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#declTip}.
	 * @param ctx the parse tree
	 */
	void exitDeclTip(MiniLangParser.DeclTipContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#listId}.
	 * @param ctx the parse tree
	 */
	void enterListId(MiniLangParser.ListIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#listId}.
	 * @param ctx the parse tree
	 */
	void exitListId(MiniLangParser.ListIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#tip}.
	 * @param ctx the parse tree
	 */
	void enterTip(MiniLangParser.TipContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#tip}.
	 * @param ctx the parse tree
	 */
	void exitTip(MiniLangParser.TipContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void enterCmdComp(MiniLangParser.CmdCompContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void exitCmdComp(MiniLangParser.CmdCompContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void enterListCmd(MiniLangParser.ListCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void exitListCmd(MiniLangParser.ListCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(MiniLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(MiniLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(MiniLangParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(MiniLangParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(MiniLangParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(MiniLangParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(MiniLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(MiniLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(MiniLangParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(MiniLangParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(MiniLangParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(MiniLangParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#listW}.
	 * @param ctx the parse tree
	 */
	void enterListW(MiniLangParser.ListWContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#listW}.
	 * @param ctx the parse tree
	 */
	void exitListW(MiniLangParser.ListWContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#elemW}.
	 * @param ctx the parse tree
	 */
	void enterElemW(MiniLangParser.ElemWContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#elemW}.
	 * @param ctx the parse tree
	 */
	void exitElemW(MiniLangParser.ElemWContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtrib(MiniLangParser.CmdAtribContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtrib(MiniLangParser.CmdAtribContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiniLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiniLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void enterExprRel(MiniLangParser.ExprRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void exitExprRel(MiniLangParser.ExprRelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#exprAd}.
	 * @param ctx the parse tree
	 */
	void enterExprAd(MiniLangParser.ExprAdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#exprAd}.
	 * @param ctx the parse tree
	 */
	void exitExprAd(MiniLangParser.ExprAdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#exprMult}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(MiniLangParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#exprMult}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(MiniLangParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(MiniLangParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(MiniLangParser.FatorContext ctx);
}