// Generated from grammar/MiniLangParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniLangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MiniLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(MiniLangParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#listDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDecl(MiniLangParser.ListDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#declTip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclTip(MiniLangParser.DeclTipContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#listId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListId(MiniLangParser.ListIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#tip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTip(MiniLangParser.TipContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#cmdComp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdComp(MiniLangParser.CmdCompContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#listCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListCmd(MiniLangParser.ListCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(MiniLangParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#cmdIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdIf(MiniLangParser.CmdIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#cmdWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdWhile(MiniLangParser.CmdWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(MiniLangParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#cmdRead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRead(MiniLangParser.CmdReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#cmdWrite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdWrite(MiniLangParser.CmdWriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#listW}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListW(MiniLangParser.ListWContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#elemW}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemW(MiniLangParser.ElemWContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#cmdAtrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtrib(MiniLangParser.CmdAtribContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MiniLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#exprRel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRel(MiniLangParser.ExprRelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#exprAd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAd(MiniLangParser.ExprAdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#exprMult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMult(MiniLangParser.ExprMultContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(MiniLangParser.FatorContext ctx);
}